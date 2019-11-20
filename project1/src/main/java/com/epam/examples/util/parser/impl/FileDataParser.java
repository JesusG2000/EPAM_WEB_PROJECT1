package com.epam.examples.util.parser.impl;


import com.epam.examples.dto.SectionCalcParameters;
import com.epam.examples.entity.Dot;
import com.epam.examples.entity.Glob;
import com.epam.examples.util.parser.DataParser;
import com.epam.examples.util.parser.ParserException;
import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.DataProviderFactory;
import com.epam.examples.util.provider.ProviderException;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileDataParser implements DataParser {
    private static final Pattern GLOB_PARAMS = Pattern.compile("((-|)[0-9]+\\.[0-9]+\\s){3}[0-9]+\\.[0-9]+$");
    // private static final Pattern DOT_PARAMS = Pattern.compile("((-|)[0-9]+\\.[0-9]+\\s){2}[0-9]+\\.[0-9]+$");
    private static final Pattern SECTION_PARAMS = Pattern.compile("((-|)[0-9]+\\.[0-9]+\\s){3}[0-9]+\\.[0-9]+\\sO([XYZ])\\s((-|)[0-9]+\\.[0-9]+\\s){2}[0-9]+\\.[0-9]+$");

    @Override
    public List<SectionCalcParameters> getSectionParams() throws ParserException, ProviderException {

        DataProvider factory = DataProviderFactory.getProvider();
        List<String> lines = factory.getLines(factory.getData("data\\information"), SECTION_PARAMS);
        List<SectionCalcParameters> parameters = new ArrayList<>();
        try {
            for (String line : lines) {
                String[] divider = line.split(" ");
                double x = Double.parseDouble(divider[0]);
                double y = Double.parseDouble(divider[1]);
                double z = Double.parseDouble(divider[2]);
                double radius = Double.parseDouble(divider[3]);//NumberFormatException
                String axis = divider[4];
                double x1 = Double.parseDouble(divider[5]);
                double y1 = Double.parseDouble(divider[6]);
                double z1 = Double.parseDouble(divider[7]);

                parameters.add(new SectionCalcParameters(new Glob(new Dot(x, y, z), radius), axis, new Dot(x1, y1, z1)));
            }
        } catch (NumberFormatException e) {
            throw new ParserException(e);
        }

        return parameters;
    }

    @Override
    public List<Glob> getGlobes() throws ParserException, ProviderException {

        DataProvider factory = DataProviderFactory.getProvider();
        List<String> lines = factory.getLines(factory.getData("data\\information"), GLOB_PARAMS);
        List<Glob> globs = new ArrayList<>();
        try {
            for (String line : lines) {
                String[] divider = line.split(" ");
                double x = Double.parseDouble(divider[0]);
                double y = Double.parseDouble(divider[1]);
                double z = Double.parseDouble(divider[2]);
                double radius = Double.parseDouble(divider[3]);
                globs.add(new Glob(new Dot(x, y, z), radius));
            }
        } catch (NumberFormatException e) {
            throw new ParserException(e);
        }
        return globs;
    }
}
