package by.it.volchek.Calc;

/**
 * Created by volchek on 05.04.18.
 */
public class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;

    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);

    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;

    }
    @Override
    public Var add (Var other) throws CalcException {

          if (other instanceof Scalar) {
              double res = this.value + ((Scalar) other).value;
              return new Scalar(res);
          }


        return other.add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double res = this.value*((Scalar) other).value;
            return new Scalar(res);
        }
        return other.mul(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sub=this.value-((Scalar) other).value;
            return new Scalar(sub);
        }
        else return new Scalar(-1).mul(other).add(this);
    }
    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double z = ((Scalar) other).value;
            if (z == 0) throw new CalcException("деление на ноль");
            double div = this.value/((Scalar) other).value;
            return new Scalar(div);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
