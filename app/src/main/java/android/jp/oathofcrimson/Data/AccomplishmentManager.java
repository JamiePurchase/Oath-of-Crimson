package android.jp.oathofcrimson.Data;

public class AccomplishmentManager
{
    private Accomplishment[] accomplishments = new Accomplishment[50];

    public AccomplishmentManager()
    {
        // Campaign Missions
        this.add("Prodigy", "Achieve five stars in all every battle during the tutorial.", false);
        // NOTE: Various challenges, including five stars for each mission in the campaign

        // Campaign Secrets
        this.add("Insight", "Discovered all 45 secret journals.", false);

        // Battle Prowess

        // Crafting Milestones
        this.add("Herbal Remedies", "Produced ten potions from successful alchemy.", false);
        this.add("Dangerous Hobby", "Produced ten poisons from successful alchemy.", false);
        this.add("Alchemist", "Complete 1000 alchemical procedures, discover 100 different ingrediants and produce ten legendary items.", false);
    }

    private void add(String title, String description, boolean secret)
    {
        new Accomplishment(title, description, secret);
    }
}