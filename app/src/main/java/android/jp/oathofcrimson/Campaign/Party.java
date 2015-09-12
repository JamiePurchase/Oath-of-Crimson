package android.jp.oathofcrimson.Campaign;

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

}