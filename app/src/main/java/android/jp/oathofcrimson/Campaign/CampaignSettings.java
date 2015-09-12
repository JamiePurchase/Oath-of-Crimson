package android.jp.oathofcrimson.Campaign;

public class CampaignSettings
{
    // Campaign
    private Campaign campaign;

    // Performance
    private int performanceFPS;

    // Visual
    //private

    // Audio
    private boolean audioEnable;

    // Data
    private boolean dataSaveAuto;

    public CampaignSettings(Campaign campaign)
    {
        // Campaign
        this.campaign = campaign;

        // Performance
        this.performanceFPS = 60;

        // Visual
        //

        // Audio
        this.audioEnable = true;

        // Data
        this.dataSaveAuto = true;
    }

    public int getPerformanceFPS()
    {
        return this.performanceFPS;
    }

}