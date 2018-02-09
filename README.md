#ProguardKeeps

这是一个可以帮助安卓开发者解决代码混淆问题的工具，开发者在不需要混淆的类上仅仅需要添加``@Keeps``。Kepps标签还可控制不需要混淆的部分(classname,fields,methods,all)，以及控制该类与其他类(onlyself,subclass,innerclass)的关系。