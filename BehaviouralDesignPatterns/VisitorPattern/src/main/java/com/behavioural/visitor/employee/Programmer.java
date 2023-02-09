package com.behavioural.visitor.employee;

import com.behavioural.visitor.Visitor;

public class Programmer extends AbstractEmployee {

    private String skill;

    public Programmer(String name, String skill) {
        super(name);
        this.skill = skill;
    }

    public String getSkill() {
        return this.skill;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
