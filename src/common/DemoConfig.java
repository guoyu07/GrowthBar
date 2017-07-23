package common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

import common.model._MappingKit;
import routes.AdminRoutes;
import routes.FrontRoutes;


public class DemoConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setEncoding("utf-8");
		PropKit.use("a_little_config.properties");
		me.setDevMode(PropKit.getBoolean("devMode", true));
	}

	@Override
	public void configRoute(Routes me) {
		me.add(new AdminRoutes());
		me.add(new FrontRoutes());
	}

	@Override
	public void configEngine(Engine me) {

	}

	/**
	 * Druid数据库连接池
	 * 
	 * @return DruidPlugin
	 */
	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}

	@Override
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);

		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		_MappingKit.mapping(arp);
		me.add(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {

	}

	@Override
	public void configHandler(Handlers me) {

	}

}
