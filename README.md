lift_basic_heroku
=================

A basic Lift project that is ready for Heroku. See [Demo on Heroku](http://liftbasicheroku.herokuapp.com/)

Start here:

    $ git clone git@github.com:icoxfog417/lift_basic_heroku.git

Create a new heroku app on their Cedar stack.  (yourappname) is application name. if blank heroku set id to your application automatically.

    $ heroku create (yourappname) --stack cedar

Deploy your code:

    $ git push heroku master

All done:

    $ heroku open

For more info about Scala on Heroku check out the [dev center](http://devcenter.heroku.com/articles/scala)

More details about the changes made to the standard Lift Basic project to get it ready for Heroku ...

**Add Main method for starting application**  
 The easiest way to start application (invoke Jetty) is , create a Main method to start jetty  
 *See LiftUp.scala - save in src/main/scala dir.*  
 Then use Typesafe's start script plugin([sbt-start-script](https://github.com/sbt/sbt-start-script)) to generate a script to start the app .

Note: make sure that project/build.properties doesn't start with a comment line.  Heroku doesn't like that.

**Disable db service**  
In default, lift use h2db for database and it's work as a service using port. But heroku's port is only one.  
So you have to change db setting "as a service" to "on memory".  
 *See Boot.scala - save in src/main/scala/bootstrap/liftweb/ dif.*  also refer [seraphr's blog]([http://d.hatena.ne.jp/seraphr/20110924/1316811093)


Based on [lift_blank_heroku by ghostm & tantaman's pull request](https://github.com/ghostm/lift_blank_heroku)
