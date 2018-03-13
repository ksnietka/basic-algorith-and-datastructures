package com.ksnietka.Matching;

import javafx.scene.input.PickResult;

import java.util.ArrayList;

public class GaleShapey {
    ArrayList<Pair> matched = new ArrayList<Pair>();
    ArrayList<Person> unmatched = new ArrayList<Person>();

    abstract class Person {
        private Person[] preferences;
        private Person partner;
        

        public Person(Person[] preferences) {
            this.preferences = preferences;
        }

        public match (Person b) {
            b.setPartner(this);
            setPartner(b);
            matched.add()
        }

        public void setPartner(Person partner) {
            this.partner = partner;
        }
    }

    class Man extends Person {
        public Man(Person[] preferences) {
            super(preferences);
        }

        private propose(Woman a) {

        }
    }

    class Woman extends Person {

        public Woman(Person[] preferences) {
            super(preferences);
        }

        public void retrivePropose(Man a) {

        }
        public void brokeUp() {

        }
    }

    class Pair {
        public Pair(Person a, Person b) {

        }
    }
}
