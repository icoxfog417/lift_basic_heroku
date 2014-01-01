Lift on Heroku (Lift v2.6 M2)
=================

A basic Lift project that is ready for Heroku. See [Demo on Heroku](http://lift26.herokuapp.com/).

## Push to heroku
1. clone repository  
`git clone git@github.com:icoxfog417/lift_basic_heroku.git`

2. create app on Heroku  
 `heroku create (yourappname) --stack cedar`

3. git push to heroku master  
 `git push heroku master`

For more info about Scala on Heroku check out the [dev center](http://devcenter.heroku.com/articles/scala)

## Technical Detail
**1.Add Main Class for starting application**  
Make Main Class to invoke jetty server.And use [sbt-start-script](https://github.com/sbt/sbt-start-script).  
ref: * src/main/scala/LiftUp.scala*  

**2.Disable db service**  
In default, lift use h2db for database and it's work as a service using port. But heroku's port is only one.  
So you have to change db setting "as a service" to "on memory".  
ref: *src/main/scala/bootstrap/liftweb/Boot.scala.* 

## References
[seraphr's blog](http://d.hatena.ne.jp/seraphr/20110924/1316811093)  
[lift_blank_heroku by ghostm & tantaman's pull request](https://github.com/ghostm/lift_blank_heroku)