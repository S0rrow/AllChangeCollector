package AllChangeCollector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Vectorize {
    public static void extract_vector(String repo_name) throws FileNotFoundException, IOException {
        System.out.println("=====> Parsing");
        System.out.println("===========> " + repo_name);
        String dir = System.getProperty("user.dir") + "/data/" + repo_name + "/gumtree_log.txt";
        File file = new File(dir);
        String vector_file = "gumtree_vector.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(vector_file));

        // reading file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            String write_line = "";

            // read each line
            boolean add = false;
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);

                // examine tokens and write for matching string
                while (st.hasMoreTokens()) {
                    String st_l = st.nextToken();
                    
                    // 
                    

                    System.out.println("substring: " + st_l); // DEBUG

                    //
                    if (st_l.equals("---")) {
                        add = true;
                    }
                    if(st_l.equals("==="))
                    {
                        add = false;
                        writer.write(write_line + '\n');
                        write_line = "";
                    }
                    if (add == true) {
                        if ((!Character.isAlphabetic(st_l.charAt(st_l.length() - 1))) && add) {
                            st_l = st_l.substring(0, st_l.length() - 1);
                        }
                        
                        for (int i = 0; i < nodes.length; i++) {
                            if (st_l.equals(nodes[i])) {
                                write_line += String.valueOf(i+4) + ", ";
                            }
                        }
                    }
                }
            }
            writer.write(write_line + '\n');
        }
        writer.close();
    }
    
    static public String[] nodes = {
            /* 4. */ "AnnotationTypeDeclaration",
            /* 5. */ "AnnotationTypeMemberDeclaration",
            /* 6. */ "AnonymousClassDeclaration",
            /* 7. */ "ArrayAccess",
            /* 8. */ "ArrayCreation",
            /* 9. */ "ArrayInitializer",
            /* 10. */ "ArrayType",
            /* 11. */ "AssertStatement",
            /* 12. */ "Assignment",
            /* 13. */ "Block",
            /* 14. */ "BlockComment",
            /* 15. */ "BooleanLiteral",
            /* 16. */ "BreakStatement",
            /* 17. */ "CastExpression",
            /* 18. */ "CatchClause",
            /* 19. */ "CharacterLiteral",
            /* 20. */ "ClassInstanceCreation",
            /* 21. */ "CompilationUnit",
            /* 22. */ "ConditionalExpression",
            /* 23. */ "ConstructorInvocation",
            /* 24. */ "ContinueStatement",
            /* 25. */ "CreationReference",
            /* 26. */ "Dimension",
            /* 27. */ "DoStatement",
            /* 28. */ "EmptyStatement",
            /* 29. */ "EnhancedForStatement",
            /* 30. */ "EnumConstantDeclaration",
            /* 31. */ "EnumDeclaration",
            /* 32. */ "ExportsDirective",
            /* 33. */ "ExpressionMethodReference",
            /* 34. */ "ExpressionStatement",
            /* 35. */ "FieldAccess",
            /* 36. */ "FieldDeclaration",
            /* 37. */ "ForStatement",
            /* 38. */ "IfStatement",
            /* 39. */ "ImportDeclaration",
            /* 40. */ "InfixExpression",
            /* 41. */ "Initializer",
            /* 42. */ "InstanceofExpression",
            /* 43. */ "IntersectionType",
            /* 44. */ "Javadoc",
            /* 45. */ "LabeledStatement",
            /* 46. */ "LambdaExpression",
            /* 47. */ "LineComment",
            /* 48. */ "MarkerAnnotation",
            /* 49. */ "MemberRef",
            /* 50. */ "MemberValuePair",
            /* 51. */ "MethodDeclaration",
            /* 52. */ "MethodInvocation",
            /* 53. */ "MethodRef",
            /* 54. */ "MethodRefParameter",
            /* 55. */ "Modifier",
            /* 56. */ "ModuleDeclaration",
            /* 57. */ "ModuleModifier",
            /* 58. */ "NameQualifiedType",
            /* 59. */ "NormalAnnotation",
            /* 60. */ "NullLiteral",
            /* 61. */ "NumberLiteral",
            /* 62. */ "OpensDirective",
            /* 63. */ "PackageDeclaration",
            /* 64. */ "ParameterizedType",
            /* 65. */ "ParenthesizedExpression",
            /* 66. */ "PostfixExpression",
            /* 67. */ "PrefixExpression",
            /* 68. */ "PrimitiveType",
            /* 69. */ "ProvidesDirective",
            /* 70. */ "QualifiedName",
            /* 71. */ "QualifiedType",
            /* 72. */ "RequiresDirective",
            /* 73. */ "Statement",
            /* 74. */ "SimpleName",
            /* 75. */ "SimpleType",
            /* 76. */ "SingleMemberAnnotation",
            /* 77. */ "SingleVariableDeclaration",
            /* 78. */ "StringLiteral",
            /* 79. */ "SuperConstructorInvocation",
            /* 80. */ "SuperFieldAccess",
            /* 81. */ "SuperMethodInvocation",
            /* 82. */ "SuperMethodReference",
            /* 83. */ "SwitchCase",
            /* 84. */ "SwitchStatement",
            /* 85. */ "SynchronizedStatement",
            /* 86. */ "TagElement",
            /* 87. */ "TextElement",
            /* 88. */ "ThisExpression",
            /* 89. */ "ThrowStatement",
            /* 90. */ "TryStatement",
            /* 91. */ "TypeDeclaration",
            /* 92. */ "TypeDeclarationStatement",
            /* 93. */ "TypeMethodReference",
            /* 94. */ "TypeLiteral",
            /* 95. */ "TypeParameter",
            /* 96. */ "UnionType",
            /* 97. */ "UsesDirective",
            /* 98. */ "VariableDeclarationExpression",
            /* 99. */ "VariableDeclarationFragment",
            /* 100. */ "VariableDeclarationStatement",
            /* 101. */ "WhileStatement",
            /* 102. */ "WildcardType",
            /* 103. */ "INFIX_EXPRESSION_OPERATOR",
            /* 104. */ "METHOD_INVOCATION_RECEIVER",
            /* 105. */ "METHOD_INVOCATION_ARGUMENTS",
            /* 106. */ "TYPE_DECLARATION_KIND",
            /* 107. */ "ASSIGNEMENT_OPERATOR",
            /* 108. */ "PREFIX_EXPRESSION_OPERATOR",
            /* 109. */ "POSTFIX_EXPRESSION_OPERATOR",
            /* 110. */ "ReturnStatement"
    };

}
