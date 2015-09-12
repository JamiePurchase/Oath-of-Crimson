package android.jp.oathofcrimson.Campaign.Characters;

import android.jp.oathofcrimson.Campaign.Campaign;
import java.util.ArrayList;

public class Party
{
    private Campaign partyCampaign;
    private ArrayList<Character> partyCharacters;

    public Party(Campaign campaign)
    {
        this.partyCampaign = campaign;
        this.partyCharacters = new ArrayList();
    }

    public void addCharacter(Character character)
    {
        this.partyCharacters.add(character);
    }

}