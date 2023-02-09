package com.behavioural.visitor;

import com.behavioural.visitor.employee.Employee;
import com.behavioural.visitor.employee.Manager;
import com.behavioural.visitor.employee.Programmer;
import com.behavioural.visitor.employee.ProjectLead;
import com.behavioural.visitor.employee.VicePresident;

public class PrintVisitor implements Visitor {
    @Override
    public void visit(Programmer dev) {
        String msg = String.format("%s programa em %s", dev.getName(), dev.getSkill());
        System.out.println(msg);
    }

    @Override
    public void visit(ProjectLead pl) {
        String msg = String.format("%s é um líder de projetos com %s em seu squad", pl.getName(), pl.getDirectReports().size());
        System.out.println(msg);
    }

    @Override
    public void visit(Manager manager) {
        String msg = String.format("%s é um gerente de projetos com %s sob sua gerência", manager.getName(), manager.getDirectReports().size());
        System.out.println(msg);
    }

    @Override
    public void visit(VicePresident vp) {
        String msg = String.format("%s é o vice presidente com %s gerentes em sua companhia", vp.getName(), vp.getDirectReports().size());
        System.out.println(msg);
    }

//    TODO think of a recursive here
//    private int getTotalOrgSize(Employee employee) {
//
//    }
}
