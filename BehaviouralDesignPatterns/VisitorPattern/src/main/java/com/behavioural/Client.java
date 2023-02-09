package com.behavioural;

import com.behavioural.visitor.PrintVisitor;
import com.behavioural.visitor.Visitor;
import com.behavioural.visitor.employee.Employee;
import com.behavioural.visitor.employee.Manager;
import com.behavioural.visitor.employee.Programmer;
import com.behavioural.visitor.employee.ProjectLead;
import com.behavioural.visitor.employee.VicePresident;

public class Client {

    public static void main(String[] args) {
        //Requirement hipotético: precisamos printar toda a organização
        //Ex: Felipe programa em Java, Brossi tem 4 reports diretos, etc.

        /* Sem o visitor, teriamos que adicionar os métodos individualmente em cada
        * classe para que possamos fazer um report completo, e então chamar um a um.
        * Porém, com o visitor, podemos fazer o seguinte: */

        Employee emps = buildOrganization();
        Visitor visitor = new PrintVisitor();

        visitOrgStructure(emps, visitor);
    }

    private static Employee buildOrganization() {
        Programmer felipe = new Programmer("Felipe", "Java");
        Programmer jess = new Programmer("Jess", "JavaScript");
        Programmer mari = new Programmer("Mari", "Java");
        Programmer may = new Programmer("May", "JavaScript");

        ProjectLead boss = new ProjectLead("Brossi", felipe, jess, mari, may);
        ProjectLead maykel = new ProjectLead("Maykel", may);

        Manager gil = new Manager("Ricardo Gil Guerrero Scavazin", boss);
        Manager dhiego = new Manager("Dhiego", maykel);

        VicePresident vp = new VicePresident("Dani Rabinovich", gil, dhiego);

        return vp;
    }

    private static void visitOrgStructure(Employee employee, Visitor visitor) {
        employee.accept(visitor);
        employee.getDirectReports().forEach(e -> visitOrgStructure(e, visitor));
    }
}
