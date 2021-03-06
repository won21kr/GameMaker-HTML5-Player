/*
 * Copyright (C) 2007 IsmAvatar <IsmAvatar@gmail.com>
 * Copyright (C) 2006 Clam <clamisgood@gmail.com>
 * 
 * This file is part of LateralGM.
 * LateralGM is free software and comes with ABSOLUTELY NO WARRANTY.
 * See LICENSE for details.
 */

package org.lateralgm.resources.sub;

import java.util.EnumMap;

import org.lateralgm.util.PropertyMap;
import org.lateralgm.util.PropertyMap.PropertyValidator;

public class PathPoint implements PropertyValidator<PathPoint.PPathPoint>
	{
	public enum PPathPoint
		{
		X,Y,SPEED
		}

	private static final EnumMap<PPathPoint,Object> DEFS = PropertyMap.makeDefaultMap(
			PPathPoint.class,0,0,100);

	public final PropertyMap<PPathPoint> properties;

	public PathPoint()
		{
		properties = new PropertyMap<PPathPoint>(PPathPoint.class,this,DEFS);
		}

	public PathPoint(int x, int y, int speed)
		{
		properties = new PropertyMap<PPathPoint>(PPathPoint.class,this,PropertyMap.makeDefaultMap(
				PPathPoint.class,x,y,speed));
		}

	public String toString()
		{
		String r = "(" + getX() + "," + getY() + ")";
		while (r.length() < 11)
			r += " ";
		return r + " sp: " + getSpeed();
		}

	public int getX()
		{
		return properties.get(PPathPoint.X);
		}

	public void setX(int x)
		{
		properties.put(PPathPoint.X,x);
		}

	public int getY()
		{
		return properties.get(PPathPoint.Y);
		}

	public void setY(int y)
		{
		properties.put(PPathPoint.Y,y);
		}

	public int getSpeed()
		{
		return properties.get(PPathPoint.SPEED);
		}

	public void setSpeed(int speed)
		{
		properties.put(PPathPoint.SPEED,speed);
		}

	public Object validate(PPathPoint k, Object v)
		{
		return v;
		}

	public boolean equals(Object o)
		{
		if (o == this) return true;
		if (o == null || !(o instanceof PathPoint)) return false;
		return properties.equals(((PathPoint) o).properties);
		}
	}
