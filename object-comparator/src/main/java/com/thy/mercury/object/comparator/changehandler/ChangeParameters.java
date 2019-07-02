package com.thy.mercury.object.comparator.changehandler;

import java.util.List;
import com.thy.mercury.object.comparator.model.ChangeReport;

public class ChangeParameters<T>
{
    private List<ChangeReport> fieldChangeReports;
    private T first;
    private T next;

    public ChangeParameters(List<ChangeReport> fieldChangeReports)
    {
        this.fieldChangeReports = fieldChangeReports;
    }
  
    public ChangeParameters(T first, T next)
    {
        this.first = first;
        this.next = next;
    }

    public ChangeParameters(T first, T next, List<ChangeReport> fieldChangeReports)
    {
        this.first = first;
        this.next = next;
        this.fieldChangeReports = fieldChangeReports;
    }

    public List<ChangeReport> getFieldChangeReports()
    {
        return fieldChangeReports;
    }

    public void setFieldChangeReports(List<ChangeReport> fieldChangeReports)
    {
        this.fieldChangeReports = fieldChangeReports;
    }

    public T getFirst()
    {
        return first;
    }

    public void setFirst(T first)
    {
        this.first = first;
    }

    public T getNext()
    {
        return next;
    }

    public void setNext(T next)
    {
        this.next = next;
    }
}
