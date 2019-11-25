package com.epam.examples.util.parser;


import com.epam.examples.bean.dto.SectionCalcParameters;
import com.epam.examples.bean.Glob;
import com.epam.examples.util.provider.ProviderException;

import java.util.List;

public interface DataParser {



  List<SectionCalcParameters> getSectionParams() throws ParserException, ProviderException;

  List<Glob> getGlobes() throws ParserException, ProviderException;





}
