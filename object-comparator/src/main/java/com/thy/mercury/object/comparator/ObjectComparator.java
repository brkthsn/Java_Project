package com.thy.mercury.object.comparator;

import java.util.List;
import com.thy.mercury.object.comparator.model.ChangeReport;
import com.thy.mercury.object.comparator.model.ComparableObject;
import com.thy.mercury.object.comparator.model.ComparatorConfig;

public interface ObjectComparator
{
     List<ChangeReport> compare(ComparableObject oldComparable, ComparableObject newComparable);

}
