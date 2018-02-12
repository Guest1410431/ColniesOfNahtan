package model;

import common.GameEnums.ResourceType;

public class ResourceCard extends Card implements Comparable<ResourceCard>
{
	public ResourceCard()
	{
		
	}
	public ResourceCard(ResourceType resource)
	{
		super(resource);
	}
	
	public int compareTo(ResourceCard card)
	{
		return Integer.compare(card.getResourceType().ordinal(), this.getResourceType().ordinal());
	}
}
