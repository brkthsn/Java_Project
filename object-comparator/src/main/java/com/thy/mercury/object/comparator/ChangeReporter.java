package com.thy.mercury.object.comparator;

import java.util.List;
import com.thy.mercury.object.comparator.model.ChangeReport;
import com.thy.mercury.object.comparator.model.ComparatorConfig;

public interface ChangeReporter<T>
{
    List<ChangeReport> generateChangeReport(T oldObj, T newObj);
}
