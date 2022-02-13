package app.enums;

public enum Phrases {
    TRILLION {
        @Override
        public String phrase(int i) {
            switch (i) {
                case 1:
                    return "триллион";

                case 2:
                case 3:
                case 4:
                    return "триллиона";

                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 0:
                    return "триллионов";

                default:
                    return null;
            }
        }

        ;
    },

    BILLION {
        @Override
        public String phrase(int i) {
            switch (i) {
                case 1:
                    return "миллиард";

                case 2:
                case 3:
                case 4:
                    return "миллиарда";

                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 0:
                    return "миллиардов";

                default:
                    return null;
            }
        }

        ;

    },

    MILLION {
        @Override
        public String phrase(int i) {
            switch (i) {
                case 1:
                    return "миллион";

                case 2:
                case 3:
                case 4:
                    return "миллиона";

                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 0:
                    return "миллионов";

                default:
                    return null;
            }
        }

        ;

    },

    THOUSAND {
        @Override
        public String phrase(int i) {
            switch (i) {
                case 1:
                    return "тысяча";

                case 2:
                case 3:
                case 4:
                    return "тысячи";

                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 0:
                    return "тысяч";

                default:
                    return null;
            }
        }

        ;

    };


    public abstract String phrase(int i);
}

