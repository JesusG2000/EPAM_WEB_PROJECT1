package com.epam.examples.util.parser;


import com.epam.examples.dto.SectionCalcParameters;
import com.epam.examples.entity.Glob;
import com.epam.examples.util.provider.ProviderException;

import java.util.List;

public interface DataParser {

  List<SectionCalcParameters> getSectionParams() throws ParserException, ProviderException;

  List<Glob> getGlobes() throws ParserException, ProviderException;



}
