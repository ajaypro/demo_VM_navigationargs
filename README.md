ViewModel and ViewModelFactory - Starter Code
==================================

Use as starter code for the ViewModel codelab.

Introduction
------------

This starter app is a two player game, GuessTheWord. It is a word guessing app you can play with one or more friends. To play, hold the device in landscape, facing away from you with your thumbs on the **Skip** and **Got It** buttons. Your friends can then give you clues to help you guess the word. If you get the word right, press **Got It**. If you're stuck, press **Skip**.
You will modify the app to use Architecture components and best practices.

ViewModel
---------
* Created `scoreviewmodel` from `scoreviewmodelfactory` factory class which is based on factory design pattern that creates viewmodel
  of the same instance.
* The factory method pattern is a creational design pattern that uses factory methods to create objects. A factory method is a method that returns an instance of the same class.
* A factory method is a method that returns an instance of the same class.
* `ViewModelProvider` returns an existing `ViewModel` if one exists, or it creates a new one if it does not already exist.
* `ViewModelProvider` creates a ViewModel instance in association with the given scope (an activity or a fragment).

License
-------

Copyright 2019 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
