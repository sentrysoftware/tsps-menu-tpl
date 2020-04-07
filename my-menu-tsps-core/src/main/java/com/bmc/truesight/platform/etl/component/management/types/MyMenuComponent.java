package com.bmc.truesight.platform.etl.component.management.types;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.bmc.truesight.api.dto.ComponentAttributeEntity;
import com.bmc.truesight.api.dto.ComponentAttributeEntity.ComponentAttributeType;
import com.bmc.truesight.api.dto.exceptions.ComponentManagementException;
import com.bmc.truesight.api.extended.component.ComponentsDAO;
import com.bmc.truesight.component.IComponentType;
import com.bmc.truesight.logging.Log;
import com.bmc.truesight.logging.LogManager;
import com.bmc.truesight.platform.etl.component.management.ComponentType;
import com.bmc.truesight.platform.etl.component.management.listener.CMEventListener.CalledFrom;
import com.bmc.tsps.common.services.asset.AssetProvider;
import com.bmc.tsps.common.services.asset.AssetRegistry;
import com.bmc.tsps.common.services.i18n.I18nFile;
import com.bmc.tsps.common.services.i18n.I18nProvider;
import com.bmc.tsps.common.services.i18n.I18nRegistry;

public class MyMenuComponent extends ComponentType {


	private static final String DEFAULT = "Default";

	/**
	 * The "type" of the Component (like "TSIM", "CO", etc.)
	 */
	public static final String COMPONENT_TYPE = "MYMENU";

	/**
	 * The logger to mymenu.log
	 */
	private static final Log LOGGER = LogManager.getInstance().getLogger(COMPONENT_TYPE);

	private boolean ready;

	/**
	 * Version of the Component
	 */
	private final String version;

	/**
	 * Platform we're running on
	 */
	private final String osName;

	/**
	 * New custom attribute for the component
	 */
	private String myAttribute;

	public MyMenuComponent() throws ComponentManagementException {

		LOGGER.info("MyMenuComponent: Instantiating Component");

		// Basic information
		super.setType(COMPONENT_TYPE);
		super.setServerDescription("My Menu");
		super.setServerDefaultHttpPort(80);
		super.setServerDefaultHttpsPort(443);
		super.setServerProtocol("HTTPS");
		super.setCheckProtocol(true);

		// Create the component attribute and add it to the set of component attributes
		this.getAttributes().add(new ComponentAttributeEntity(
				"myAttribute",
				"My attribute",
				"my-menu.my-attribute.display",
				DEFAULT,
				ComponentAttributeType.TEXT,
				DEFAULT,
				"Custom component attribute example.", "my-menu.my-attribute.description",
				2,
				true,
				255,
				0,
				(String) null,
				"my-menu.my-attribute.required",
				""
			));

		// Get and set version
		version = this.getVersion();
		LOGGER.info("MyMenuComponent: version: " + version);

		// OS we're running on
		osName = System.getProperty("os.name");
	}

	/**
	 * Class whose only purpose is to have a valid AssetProvider that we will ask
	 * the AssetRegistry to remove (even though it's not there), just to get the
	 * AssetRegistry to refresh itself
	 */
	private class FakeAssetProvider implements AssetProvider {

		@Override
		public List<String> getCss() {
			return null;
		}

		@Override
		public List<String> getJavascripts() {
			return null;
		}

		@Override
		public List<String> getModules() {
			return null;
		}

	}

	/**
	 * Class whose only purpose is to have a valid I18nProvider that we will ask the
	 * I18nRegistry to remove (even though it's not there), just to get the
	 * I18nRegistry to refresh itself
	 */
	private class FakeI18nProvider implements I18nProvider {

		@Override
		public Collection<I18nFile> getResources() {
			return null;
		}

	}

	@Override
	public void componentInfoNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		// Not implemented
	}

	@Override
	public void connectedNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		// Not implemented
	}

	@Override
	public void deleteErrorNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		// Not implemented
	}

	@Override
	public void deleteNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		LOGGER.info("MyMenuComponent: Component getting deleted");

		// Sets our readiness to false
		setReady(false);
	}

	@Override
	public void disconnectedNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		// Not implemented

	}

	@Override
	public void errorNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		setReady(false);
	}

	@Override
	public void forceDeleteNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		LOGGER.info("MyMenuComponent: Component getting force-deleted");

		// Sets our readiness to false
		setReady(false);

	}

	@Override
	public void heartbeatNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		// Not implemented

	}

	@Override
	public void initDeleteNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		// Not implemented
	}

	@Override
	public void initializationErrorNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		this.setReady(false);
	}

	@Override
	public void initializationNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		this.initialize();
	}

	private void initialize() throws ComponentManagementException {

		// Tenant must be '*'
		if (!"*".equals(super.getServerTenant())) {
			throw new ComponentManagementException("My Menu Component must be configured for Tenant '*' only.");
		}

		// There must be only one instance of the My Menu component
		final List<IComponentType> myMenuComponentList = ComponentsDAO.getComponentsByType(COMPONENT_TYPE)
				.orElse(new ArrayList<IComponentType>());
		if (myMenuComponentList.indexOf(this) != 0) {
			throw new ComponentManagementException("There must be only 1 instance of the My Menu Component.");
		}

		// Set myAttribute
		final Optional<ComponentAttributeEntity> myAttributeOptional = this.getAttributes().stream()
				.filter(attribute -> attribute.getKey().equals("myAttribute")).findFirst();

		if (myAttributeOptional.isPresent()) {
			try {
				// Get the configured value and set in the current instance
				this.setMyAttribute(myAttributeOptional.get().getAttributeValue());
			} catch (final Exception e) {
				final String message = "MyMenuComponent: Could not configure myAttribute";
				LOGGER.error(message, e);
			}

		}

		// Now we're ready
		setReady(true);

	}

	public boolean isReady() {
		return ready;
	}

	@Override
	public void registerationErrorNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		this.setReady(false);
	}

	@Override
	public void registrationNotification(final boolean paramBoolean, final CalledFrom paramCalledFrom)
			throws ComponentManagementException {
		LOGGER.info("MyMenuComponent: Component registered for " + this.getServerDNSName()
				+ " (no actual connection will be made)");
		super.setServerVersion(version);
		super.setServerOs(osName);

	}

	@Override
	public void relatedComponentChangedNotification(final ComponentType paramComponentType, final String paramString)
			throws ComponentManagementException {
		// Not implemented
	}

	public void setReady(final boolean ready) {
		this.ready = ready;

		// Update TSPS's assets registry (little hack)
		LOGGER.info("MyMenuComponent: Setting ready to " + ready + " and updating AssetRegistry and I18nRegisstry");
		AssetRegistry.getInstance().removeProvider(new FakeAssetProvider());
		I18nRegistry.getInstance().unregister(new FakeI18nProvider());
	}

	@Override
	public void updateErrorNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		// Not implemented
	}

	@Override
	public void updateNotification(final CalledFrom paramCalledFrom) throws ComponentManagementException {
		initialize();
	}

	/**
	 * Read the build properties (in /my-menu-build.properties resource file)
	 * <p>
	 * 
	 * @return Build properties as a Properties collection
	 * @throws IOException
	 */
	private Properties getBuildProperties() throws IOException {

		// Read the properties resource
		Properties properties;
		try (InputStream propStream = MyMenuComponent.class.getResourceAsStream("/my-menu-build.properties")) {

			if (propStream == null) {
				throw new IOException("Cannot get build properties");
			}

			// Convert to Properties
			properties = new Properties();
			try {
				properties.load(propStream);
			} catch (final Exception e) {
				throw new IOException("Unable to load build properties", e);
			}

		}

		return properties;

	}

	private String getVersion() throws ComponentManagementException {
		// Read the properties resource
		Properties properties;
		try {
			properties = this.getBuildProperties();
		} catch (final IOException e) {
			LOGGER.info(
					"MyMenuComponent: Error while reading build properties: " + e.getClass().getSimpleName() + ": "
							+ e.getMessage());
			throw new ComponentManagementException("Error while reading build properties", e);
		}

		// Get version
		return properties.getProperty("version", "N/A");
	}

	public String getMyAttribute() {
		return myAttribute;
	}

	public void setMyAttribute(final String myAttribute) {
		LOGGER.info("MyMenuComponent: configured myAttribute value: " + myAttribute);
		this.myAttribute = myAttribute;
	}
}
