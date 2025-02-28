/*
 * package com.utilities;
 * 
 * import com.constants.EnvironmentConstants; import
 * com.driverManager.DriverFactory; import com.pages.LoginPage; import
 * com.pages.ProgramPage;
 * 
 * import io.cucumber.core.backend.ObjectFactory; import
 * io.cucumber.picocontainer.PicoFactory;
 * 
 * public class PicoDependencyInjector implements ObjectFactory {
 * 
 * private PicoFactory delegate = new PicoFactory();
 * 
 * public PicoDependencyInjector() {
 * 
 * addClass(DriverFactory.class); addClass(EnvironmentConstants.class);
 * addClass(ConfigReader.class); addClass(LoginPage.class);
 * addClass(ProgramPage.class); }
 * 
 * @Override public void start() { delegate.start();
 * 
 * }
 * 
 * @Override public boolean addClass(Class<?> glueClass) {
 * 
 * return delegate.addClass(glueClass); }
 * 
 * @Override public <T> T getInstance(Class<T> glueClass) {
 * 
 * return delegate.getInstance(glueClass); }
 * 
 * @Override public void stop() { delegate.stop();
 * 
 * } }
 */