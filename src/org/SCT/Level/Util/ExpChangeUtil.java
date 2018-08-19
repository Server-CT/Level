package org.SCT.Level.Util;

import org.SCT.Core.Util.ActionBarUtil;
import org.SCT.Level.Language;
import org.SCT.Level.Level;
import org.SCT.Level.Dao.ServiceDao;
import org.SCT.Level.Event.PlayerExpChangeEvent;
import org.SCT.Level.File.ConfigReader;
import org.bukkit.entity.Player;

public class ExpChangeUtil {

    private static int newexp = 0;
    private static int oldexp = 0;

    public static void AddExp(String name, int exp, Player p) {

        oldexp = ServiceDao.getPlayerExp(name);
        newexp = oldexp + exp;
        //首先设置玩家等级
        ServiceDao.setPlayerExp(name, newexp);
        //下面开始找经验近似的等级，向下取值
        for(int i = 0; i <= ConfigReader.levelMap.size(); i++) {
            //设置后经验 < 遍历数据， 那就是他了
            if(newexp < ConfigReader.levelMap.get(i)) {
                //遍历从0开始，然而我们等级从1开始，所以不需要i-1
                ServiceDao.setPlayerLevel(name, i);
                ActionBarUtil.sendActionBar(p, Language.getExp
                		.replace("%lvl%", String.valueOf(i))
                		.replace("%exp%", String.valueOf(newexp))
                		.replace("%newE%", String.valueOf(exp)));
            }
        }
        PlayerExpChangeEvent event = new PlayerExpChangeEvent(p, String.valueOf(oldexp), String.valueOf(newexp));
        Level.getInstance().getServer().getPluginManager().callEvent(event);
    }
}
