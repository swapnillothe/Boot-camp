package day1;

    public class Dimension {

        private final double dimension;

        public Dimension(double dimension) throws Exception {
            validate(dimension);
            this.dimension = dimension;
        }

        private void validate(double dimension) throws Exception {
            if(dimension < 0) throw new Exception("Invalid Parameter");
        }

        double getDimension() {
            return this.dimension;
        }
    }

