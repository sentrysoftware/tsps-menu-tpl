/**
 * Classes mimicking BMC TSPS code that is necessary to compile the Java code
 * that declares our menu.
 *
 * These classes are excluded from the .war artifact and from the plugin .zip file
 * as their "real" counterparts will be provided at runtime in the classpath of
 * the JVM executing TSPS and our code.
 *
 * DO NOT CHANGE.
 */
package com.bmc.tsps.common.services.menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menu implements Comparable<Menu> {
	private String id;
	private final String link;
	private final String text;
	private int position;
	private Set<String> permissions;
	private List<Menu> menus;
	private String componentType;
	private String displayLabel;
	private boolean hasIndexPage;

	public Menu(final String text, final String link) {
		this.text = text;
		this.link = link;
		this.position = 99;
		this.componentType = "other";
		this.permissions = new HashSet<>();
		this.menus = new ArrayList<>();

		this.id = "";
		if (link != null && link.length() > 3) {
			this.id = link.substring(3).replace('/', '-');
		}
	}

	public Menu(final String text, final String link, final String permission) {
		this(text, link);
		this.permissions.add(permission);
	}

	public Menu(final String text, final String link, final Set<String> permissions) {
		this(text, link);
		this.permissions = permissions;
	}

	public Menu(final String text, final String link, final int position) {
		this(text, link);
		this.position = position;
	}

	public Menu(final String text, final String link, final String permission, final int position) {
		this(text, link, permission);
		this.position = position;
	}

	public Menu(final String text, final String link, final Set<String> permissions, final int position) {
		this(text, link, permissions);
		this.position = position;
	}

	public Menu(final String text, final String link, final Set<String> permissions, final String componentType,
			final int position) {
		this(text, link, permissions);
		this.position = position;
		this.componentType = componentType;
	}

	public Menu(final String text, final String link, final String permission, final String componentType,
			final int position) {
		this(text, link, permission);
		this.position = position;
		this.componentType = componentType;
	}

	public Menu(final String text, final String link, final String permission, final String componentType,
			final int position, final String label) {
		this(text, link, permission);
		this.position = position;
		this.componentType = componentType;
		this.displayLabel = label;
	}

	public Menu(final String text, final String link, final String permission, final String componentType,
			final int position, final String label, final boolean hasIndexPage) {
		this(text, link, permission);
		this.position = position;
		this.componentType = componentType;
		this.displayLabel = label;
		this.hasIndexPage = hasIndexPage;
	}

	public Menu(final String text, final String link, final Set<String> permissions, final String componentType,
			final int position, final String label) {
		this(text, link, permissions);
		this.position = position;
		this.componentType = componentType;
		this.displayLabel = label;
	}

	public Menu(final String text, final String link, final Set<String> permissions, final String componentType,
			final int position, final String label, final boolean hasIndexPage) {
		this(text, link, permissions);
		this.position = position;
		this.componentType = componentType;
		this.displayLabel = label;
		this.hasIndexPage = hasIndexPage;
	}

	public String getId() {
		return this.id;
	}

	public String getLink() {
		return this.link;
	}

	public String getText() {
		return this.text;
	}

	public int getPosition() {
		return this.position;
	}

	public String getPermissions() {
		return String.join(",", this.permissions);
	}

	public void mergePermissions(final Menu menu) {
		this.permissions.addAll(menu.permissions);
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(final List<Menu> menus) {
		this.menus = menus;
	}

	public String getComponentType() {
		return this.componentType;
	}

	public void setComponentType(final String componentType) {
		this.componentType = componentType;
	}

	public String getDisplayLabel() {
		return this.displayLabel;
	}

	@Override
	public boolean equals(final Object o) {
		return (o instanceof Menu && this.link.equals(((Menu) o).getLink()));
	}

	@Override
	public int hashCode() {
		return this.link.hashCode();
	}

	@Override
	public int compareTo(final Menu o) {
		return this.link.compareTo(o.getLink());
	}

	public boolean isHasIndexPage() {
		return this.hasIndexPage;
	}

	public void setHasIndexPage(final boolean hasIndexPage) {
		this.hasIndexPage = hasIndexPage;
	}
}