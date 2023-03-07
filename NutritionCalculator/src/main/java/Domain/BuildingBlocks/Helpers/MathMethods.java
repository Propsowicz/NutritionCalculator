package Domain.BuildingBlocks.Helpers;

public class MathMethods {
    public static Double Round(Double Value, Integer Precision){
        if (Precision == 0) { return (double)Math.round(Value); }

        Integer precisionScale = (int)Math.pow(10, Precision);
        return (double)Math.round(Value * precisionScale) / precisionScale;
    }
}
