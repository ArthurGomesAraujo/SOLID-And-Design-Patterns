package com.behavioural.visitor;

import com.behavioural.visitor.employee.Manager;
import com.behavioural.visitor.employee.Programmer;
import com.behavioural.visitor.employee.ProjectLead;
import com.behavioural.visitor.employee.VicePresident;

public interface Visitor {

    //Aqui estamos usando overload, mas não precisa. Poderia ser visitProgrammer, visitPL, etc...

    void visit(Programmer dev);
    void visit(ProjectLead pl);
    void visit(Manager manager);
    void visit(VicePresident vp);

}
