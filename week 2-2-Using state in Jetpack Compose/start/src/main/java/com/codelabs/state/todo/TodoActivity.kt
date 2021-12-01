/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelabs.state.todo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.codelabs.state.ui.StateCodelabTheme

class TodoActivity : AppCompatActivity() {

    val todoViewModel by viewModels<TodoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateCodelabTheme {
                Surface {
                    TodoActivityScreen(todoViewModel)
                }
            }
        }
    }

    @Composable
    private fun TodoActivityScreen(todoViewModel: TodoViewModel) {


        //ob
        val items : List<TodoItem> by todoViewModel.todoItems.observeAsState(listOf()) // in the next steps we'll complete this
        //TodoEvent에서 Event를 전달받아 Viewmodel로 event 보낸다.
        //내부 observer가 Lifecycle.State.DESTROYED 일때 알아서 제거된다.
        TodoScreen(
            items = items,
            //이렇게도 사용할수 있다.
            onAddItem = todoViewModel::addItem, // in the next steps we'll complete this
            onRemoveItem = { todoViewModel.removeItem(it) } // in the next steps we'll complete this
        )
    }

}
