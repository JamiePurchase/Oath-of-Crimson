package android.jp.oathofcrimson.Campaign.Quest;

import android.jp.oathofcrimson.Campaign.Campaign;

import java.util.ArrayList;

public class Quest
{
    private Campaign questCampaign;
    private String questTitle;
    private QuestType questType;
    private ArrayList<QuestStage> questStageArray;
    private int questStageActive;
    private QuestStatus questStatus;

    public Quest(Campaign campaign, String title, QuestType type, ArrayList<QuestStage> stage, int current, QuestStatus status)
    {
        this.questCampaign = campaign;
        this.questTitle = title;
        this.questType = type;
        this.questStageArray = stage;
        this.questStageActive = current;
        this.questStatus = status;
    }

}