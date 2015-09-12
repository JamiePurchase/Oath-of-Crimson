package android.jp.oathofcrimson.Battle.Command;

public class MenuOption
{
    private Menu optionMenu;
    private String optionRef, optionCaption, optionHint;
    private MenuOptionType optionType;
    private boolean optionSelect;

    public MenuOption(Menu menu, String ref, String caption, MenuOptionType type, String hint)
    {
        this.optionMenu = menu;
        this.optionRef = ref;
        this.optionCaption = caption;
        this.optionHint = hint;
        this.optionType = type;
        this.optionSelect = false;
    }

    public String getRef()
    {
        return this.optionRef;
    }

    public boolean isSelected()
    {
        return this.optionSelect;
    }

    public void select(boolean value)
    {
        this.optionSelect = value;
    }

}