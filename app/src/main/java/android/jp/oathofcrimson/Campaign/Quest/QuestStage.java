package android.jp.oathofcrimson.Campaign.Quest;

public class QuestStage
{
    private Quest stageQuest;
    private String stageTitle;
    private String stageDescription;

    public QuestStage(Quest quest, String title, String description)
    {
        this.stageQuest = quest;
        this.stageTitle = title;
        this.stageDescription = description;
    }

}