package android.jp.oathofcrimson.Campaign.Characters;

import android.jp.oathofcrimson.Battle.UnitRow;
import android.jp.oathofcrimson.Campaign.Items.ItemWeapon;

public class Character
{
    // Character
    private Party characterParty;
    private String characterRef;
    private String characterName;

    // Formation
    private int formationPos;
    private UnitRow formationRow;

    // Stats
    private int statHealthNow, statHealthMax;
    private int statMysticNow, statMysticMax;

    // Equipment
    private ItemWeapon equipWeapon;
    //private ItemArmour equipArmour;

    // Abilities

    // Effects

    // Experience

    public Character(Party party, String ref, String name, int pos, UnitRow row, int healthNow, int healthMax, int mysticNow, int mysticMax, ItemWeapon weapon)
    {
        // Character
        this.characterParty = party;
        this.characterRef = ref;
        this.characterName = name;

        // Formation
        this.formationPos = pos;
        this.formationRow = row;

        // Stats
        this.statHealthNow = healthNow;
        this.statHealthMax = healthMax;
        this.statMysticNow = mysticNow;
        this.statMysticMax = mysticMax;

        // Equipment
        this.equipWeapon = weapon;

        // Abilities

        // Effects

        // Experience
    }
}