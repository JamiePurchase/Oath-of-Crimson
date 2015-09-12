package android.jp.oathofcrimson.Campaign;

import android.jp.oathofcrimson.Campaign.Characters.Character;
import android.jp.oathofcrimson.Battle.UnitRow;
import android.jp.oathofcrimson.Campaign.Characters.Party;
import android.jp.oathofcrimson.Campaign.Items.ItemWeapon;
import android.jp.oathofcrimson.Campaign.Quest.Quest;
import android.jp.oathofcrimson.Campaign.Accomplishment.AccomplishmentManager;
import android.jp.oathofcrimson.Campaign.Items.Item;
import android.jp.oathofcrimson.Game.GameDisplay;

import java.util.ArrayList;

public class Campaign
{
    // Campaign
    private String campaignRef;
    private int campaignTime;

    // Party
    private Party partyCharacter;
    private int partyGold;
    private ArrayList<Item> partyInventory;

    // Quests
    private ArrayList<Quest> questArray;
    private int questActive;

    // Accomplishments
    private AccomplishmentManager accomplishment;

    // Settings
    //

    public Campaign()
    {
        // Campaign
        this.campaignRef = "TEST";
        this.campaignTime = 0;

        // NOTE: may want a class that holds many different statistics

        // Party
        this.partyCharacter = new Party(this);
        Character player = new Character(this.partyCharacter, "TEST", "PLAYER", 0, UnitRow.FRONT, 100, 100, 50, 50, new ItemWeapon("Iron Sword", GameDisplay.assetIconWeaponSword1, 24));
        this.partyCharacter.addCharacter(player);
        this.partyGold = 0;
        this.partyInventory = new ArrayList();

        // Quests
        this.questArray = new ArrayList();
        this.questActive = 0;

        // Accomplishments
        accomplishment = new AccomplishmentManager(this);

        // Settings
        //
    }
}