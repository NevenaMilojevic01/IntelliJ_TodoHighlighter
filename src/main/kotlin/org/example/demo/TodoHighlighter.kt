package org.example.demo

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiComment
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.colors.EditorColorsScheme
import java.awt.Font


class TodoHighlighter : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        // Check if the element is a comment and contains "TODO"
        if (element is PsiComment && element.text.contains("TODO")) {
            val attributesKey = TextAttributesKey.createTextAttributesKey(
                "TODO_HIGHLIGHT",
                TextAttributes(
                    EditorColorsManager.getInstance().globalScheme.defaultForeground,
                    null,
                    EditorColorsManager.getInstance().globalScheme.defaultForeground,
                    null,
                    Font.BOLD
                )
            )

            holder.createInfoAnnotation(element, "Highlighted TODO")
                .textAttributes = attributesKey
        }
    }
}
