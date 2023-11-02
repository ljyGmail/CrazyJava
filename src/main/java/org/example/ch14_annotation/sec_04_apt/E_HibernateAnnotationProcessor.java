package org.example.ch14_annotation.sec_04_apt;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
// 指定可处理@Persistent, @Id, @Property三个注解
@SupportedAnnotationTypes({"org.example.ch14_annotation.sec_04_apt.A_Persistent", "org.example.ch14_annotation.sec_04_apt.B_Id", "org.example.ch14_annotation.sec_04_apt.C_Property"})
public class E_HibernateAnnotationProcessor extends AbstractProcessor {

    // 循环处理每个需要处理的程序对象
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // 定义一个文件输出流，用于生成额外的文件
        PrintStream ps = null;
        try {
            // 遍历每个被@Persistent修饰的class文件
            for (Element t : roundEnv.getElementsAnnotatedWith(A_Persistent.class)) {
                // 获取正在处理的类名
                Name clazzName = t.getSimpleName();
                // 获取类定义前的@Persistent注解
                A_Persistent per = t.getAnnotation(A_Persistent.class);
                // 创建文件输出流
                ps = new PrintStream(new FileOutputStream(clazzName + ".hbm.xml"));
                // 执行输出
                ps.println("<?xml version=\"1.0\"?>");
                ps.println("<!DOCTYPE hibernate-mapping PUBLIC");
                ps.println("   \"-//Hibernate/Hibernate "
                        + "Mapping DTD 3.0//EN\"");
                ps.println("     \"http://www.hibernate.orog/dtd/"
                        + "hibernate-mapping-3.0.dtd\">");
                ps.println("<hibernate-mapping>");
                ps.print("    <class name=\"" + t);
                // 输出per的table()的值
                ps.println("\" table=\"" + per.table() + "\">");

                for (Element f : t.getEnclosedElements()) {
                    // 只处理成员变量上的注解
                    if (f.getKind() == ElementKind.FIELD) {
                        // 获取成员变量定义前的@Id注解
                        B_Id id = f.getAnnotation(B_Id.class);
                        // 当@Id注解存在时输出<id.../>元素
                        if (id != null) {
                            ps.println("        <id name=\""
                                    + f.getSimpleName()
                                    + "\" column=\"" + id.column()
                                    + "\" type=\"" + id.type()
                                    + "\">");
                            ps.println("        <generator class=\""
                                    + id.generator() + "\"/>");
                            ps.println("        </id>");
                        }
                        // 获取成员变量定义前的@Property注解
                        C_Property p = f.getAnnotation(C_Property.class);
                        // 当@Property注解存在时输出<property.../>元素
                        if (p != null) {
                            ps.println("        <property name=\""
                                    + f.getSimpleName()
                                    + "\" column=\"" + p.column()
                                    + "\" type=\"" + p.type()
                                    + "\"/>");
                        }
                    }
                }
                ps.println("    </class>");
                ps.println("</hibernate-mapping>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return true;
    }
}
