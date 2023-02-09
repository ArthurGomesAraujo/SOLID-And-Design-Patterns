package com.behavioural.visitor.employee;

import com.behavioural.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProjectLead extends AbstractEmployee {

    private List<Employee> directReports = new ArrayList<>();

    public ProjectLead(String name, Employee ...employees) {
        super(name);
        Arrays.stream(employees).forEach(directReports::add);
    }

    @Override
    public Collection<Employee> getDirectReports() {
        return directReports;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
