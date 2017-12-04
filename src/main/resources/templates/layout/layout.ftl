<#include "/layout/spring.ftl"/>
<#include "/layout/frame/top.ftl"/>
<#include "/layout/frame/left.ftl"/>
<#macro page title >
    <@top title="==顶部=="></@top>
    <@left title="==左侧=="></@left>
    <#nested>
</#macro>