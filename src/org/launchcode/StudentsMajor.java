package org.launchcode;

public enum StudentsMajor {
    IT{
        @Override
        public String toString() {
            return "Informatyka";
        }
    },
    AW{
        @Override
        public String toString() {
            return "Architektura wnetrz";
        }
    },
    GRAPH{
        @Override
        public String toString() {
            return "Grafika";
        }
    },
    CULT{
        @Override
        public String toString() {
            return "Kulturoznawstwo";
        }
    },
    IM{
        @Override
        public String toString() {
            return "Zarzadzanie informacja";
        }
    }
    ;


}
