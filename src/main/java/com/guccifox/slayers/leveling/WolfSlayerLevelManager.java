package com.guccifox.slayers.leveling;

import com.guccifox.slayers.Slayers;
import com.guccifox.slayers.utilities.Utilities;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

import java.text.NumberFormat;

public class WolfSlayerLevelManager {

    @Getter @Setter private int level;
    @Getter @Setter private int xp;
    public int maxLevel = 9;

    /**
     *
     * @param level the level of the wolf slayer
     * @param xp amount of xp
     */
    public WolfSlayerLevelManager(int level, int xp) {
        this.level = level;
        this.xp = xp;
    }

    /**
     *
     * @return the players next level
     */
    public int getNextLevel() {
        return level+1;
    }

    /**
     *
     * @return next levels xp requirement (string)
     */
    public String getNextLevelXp() {
        int nextLevelXp = Slayers.getPlugin().getConfig().getInt("Wolf.Levels." + getNextLevel() + ".xp");
        if (nextLevelXp < 1000) {
            return Integer.toString(nextLevelXp);
        } else {
            return Utilities.formatValue(nextLevelXp);
        }
    }

    /**
     *
     * @return next levels xp requirement (int)
     */
    public int getNextLevelXpInt() {
        return Slayers.getPlugin().getConfig().getInt("Wolf.Levels." + getNextLevel() + ".xp");
    }

    /**
     *
     * @return amount of xp till the next level
     */
    public String getXpTillNextLevel() {
        int xpTillNextLevel = Slayers.getPlugin().getConfig().getInt("Wolf.Levels." + getNextLevel() + ".xp") - xp;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(0);
        return nf.format(xpTillNextLevel);
    }

    /**
     *
     * @return progress bar for amount of xp
     */
    public String getProgressBar() {
        float percent = (float) getXp() / getNextLevelXpInt();
        int progressBars = (int) (20 * percent);

        return StringUtils.repeat(ChatColor.DARK_PURPLE + "-", progressBars)
                + StringUtils.repeat(ChatColor.WHITE + "-", 20 - progressBars);
    }

    /**
     *
     * @return formatted xp
     */
    public String getFormattedXp() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(0);
        return nf.format(xp);
    }

    /**
     *
     * @return max level for wolf slayers
     */
    public int getMaxLevel() {
        return maxLevel;
    }
}
