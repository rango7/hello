/*
 * SonarQube Java Custom Rules Example
 * Copyright (C) 2016-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
/*
 * Creation : 20 avr. 2015
 */
package com.evergrande.sonar.checks;

import com.evergrande.sonar.util.PropertyUtils;
import com.google.common.collect.ImmutableList;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.List;


@Rule(key = "AvoidSuperClass")
/**
 * @author shatsht
 */
public class AvoidSuperClassRule extends IssuableSubscriptionVisitor {

    public static final List<String> SUPER_CLASS_AVOID = ImmutableList.of(PropertyUtils.getValue("avoid.super.class.list"));

    @Override
    public List<Tree.Kind> nodesToVisit() {
        // Register to the kind of nodes you want to be called upon visit.
        return ImmutableList.of(Tree.Kind.CLASS);
    }
    public  void  setsUper(){

    }
    public  void  visittRee(){

    }

    @Override
    public void visitNode(Tree tree) {
        visittRee();
        // Visit CLASS node only => cast could be done
        ClassTree treeClazz = (ClassTree) tree;

        // No extends => stop to visit class
        if (treeClazz.superClass() == null) {
            return;
        }

        // For 'symbolType' usage, jar in dependencies must be on classpath, !unknownSymbol! result otherwise
        String superClassName = treeClazz.superClass().symbolType().fullyQualifiedName();

        // Check if superClass avoid
        if (SUPER_CLASS_AVOID.contains(superClassName)) {
            reportIssue(tree, String.format("The usage of super class %s is forbidden", superClassName));
        }
    }

}
