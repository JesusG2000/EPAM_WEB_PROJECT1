package com.epam.examples.util.parser;

import com.epam.examples.entity.Dot;
import com.epam.examples.entity.Glob;

import java.util.List;

public interface DataProvider {

  List<Dot> getDots();

  List<Glob> getGlobes();

}
