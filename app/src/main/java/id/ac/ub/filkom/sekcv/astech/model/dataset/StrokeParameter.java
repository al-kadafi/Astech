package id.ac.ub.filkom.sekcv.astech.model.dataset;

import java.util.Arrays;

/**
 * This <AppStroke> project in package <id.ac.ub.filkom.sekcv.appstroke.model.dataset> created by :
 * Name         : syafiq
 * Date / Time  : 29 August 2016, 10:24 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class StrokeParameter
{
    private final double[] parameter;

    public StrokeParameter(double age, double cholesterol, double hdl, double ldl, double triglyceride)
    {
        this.parameter = new double[] {age, cholesterol, hdl, ldl, triglyceride};
    }

    public StrokeParameter(final double[] parameter)
    {
        this.parameter = parameter;
    }

    public double[] getParameter()
    {
        return parameter;
    }

    public double getParameter(final int indexParams)
    {
        return this.parameter[indexParams];
    }

    public int getAge()
    {
        return (int) this.parameter[id.ac.ub.filkom.sekcv.astech.model.algorithm.svm.core.component.Parameter.AGE.ordinal()];
    }

    public double getCholesterol()
    {
        return this.parameter[id.ac.ub.filkom.sekcv.astech.model.algorithm.svm.core.component.Parameter.CHOLESTEROL.ordinal()];
    }

    public double getHdl()
    {
        return this.parameter[id.ac.ub.filkom.sekcv.astech.model.algorithm.svm.core.component.Parameter.HDL.ordinal()];
    }

    public double getLdl()
    {
        return this.parameter[id.ac.ub.filkom.sekcv.astech.model.algorithm.svm.core.component.Parameter.LDL.ordinal()];
    }

    public double getTriglyceride()
    {
        return this.parameter[id.ac.ub.filkom.sekcv.astech.model.algorithm.svm.core.component.Parameter.TRIGLYCERIDE.ordinal()];
    }

    @Override
    public String toString()
    {
        return "StrokeParameter{" +
                "parameter=" + Arrays.toString(parameter) +
                '}';
    }
}
