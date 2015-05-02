package android.jp.oathofcrimson.Battle;

public class TemplateAlly
{
    public TemplateAlly(UnitAlly unit, String template)
    {
        if(template == "Temp") {loadTemp(unit);}
    }

    private void loadTemp(UnitAlly unit)
    {
        // Note: Will need to take some values from the party unit stats
        unit.setStatHealthNow(100);
        unit.setStatHealthMax(100);
        unit.setStatMysticNow(100);
        unit.setStatMysticMax(100);
        unit.setStatOverdrive(0);
    }
}