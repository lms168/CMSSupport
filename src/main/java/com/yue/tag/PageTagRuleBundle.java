package com.yue.tag;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

/**
 * s3预定义的标签只有head,body,title几个标签
 * 自定义标签
 * Created by lms on 16-6-14.
 */
public class PageTagRuleBundle implements TagRuleBundle{

    public void install(State defaultState, ContentProperty contentProperty,
                        SiteMeshContext siteMeshContext) {
        defaultState.addRule("pageHeader",new ExportTagToContentRule(siteMeshContext,contentProperty.getChild("pageHeader"),false));
        defaultState.addRule("pageContent",new ExportTagToContentRule(siteMeshContext,contentProperty.getChild("pageContent"),false));

    }


    public void cleanUp(State defaultState, ContentProperty contentProperty,
                        SiteMeshContext siteMeshContext) {

    }
}
