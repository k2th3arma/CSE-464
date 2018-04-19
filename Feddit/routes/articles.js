var express = require('express');
var bodyParser = require("body-parser");

var app = express();
app.use(bodyParser.json());

const {ObjectId} = require('mongodb');


var monk = require('monk');
var db = monk('localhost:27017/articles');



/* Upvote and downvote comments*/
app.post('/comments/:id/:commentid/:votes', function(req,res){
    var collection = db.get('articles');
    console.log("I'm trying to control up/down votes " + req.params.votes);
    var adding = Number(req.params.votes);
    var key = req.params.commentid;
    collection.update(
        { _id: req.params.id, "comments.commentid": ObjectId(key) },
        { $set: { "comments.$.votes": Number(adding) } },
        {multi:false, upsert:true},
        function(err,doc,next){
            console.log(err);
            console.log(doc);
            res.send(doc);
        });

});


/* Upvote and downvote articles*/
app.post('/:id/:votes', function(req,res){
    var collection = db.get('articles');
    console.log("I'm trying to control up/down votes " + req.params.votes);
    var adding = Number(req.params.votes);
    collection.update(
        { _id: req.params.id },
        { $set: { votes: Number(adding) } },
        {multi:false},
        function(err,doc,next){
            console.log(err);
            console.log(doc);
            res.send(doc);
        });

});


/*Obtain articles from db*/
app.get('/', function(req, res){
    var collection = db.get('articles');
    collection.find({}, function(err, articles){
        if (err) throw err;
        res.json(articles);
    });
});

/*Obtain an article via ID*/
app.get('/:id', function(req, res) {
    var collection = db.get('articles');
    console.log("article get " + req.params.id);
    collection.findOne({ _id: req.params.id}, function(err, articles){
        if (err) throw err;
      	res.json(articles);
    });
});

/*Obtain an article comment via ID*/
app.get('/:id/:commentid', function(req, res) {
    var collection = db.get('articles');
    console.log("commentid get " + req.params.commentid);
    var key = req.params.commentid;
    console.log("commentid get " + key);
    collection.findOne({ _id: req.params.id}, function(err, articles){
        if (err) throw err;
        console.log(articles);
        res.json(articles);
    });
});

/*Delete article via ID*/
app.delete('/:id', function(req,res){
    var collection = db.get('articles');
    collection.remove({_id: req.params.id}, function(err,article){
        if (err) throw err;

        res.json(article);
    });
});

/*Delete comment via ID*/
app.delete('/:id/:commentid', function(req,res){

    var collection = db.get('articles');
    console.log("I made it here " + req.params.commentid);
    var key = req.params.commentid;
    collection.update(
        { _id: req.params.id },
        { $pull: { comments: { commentid: ObjectId(key) } } },
        {multi:false},
        function(err,doc,next){
        console.log(err);
        console.log(doc);
        res.send(doc);
    });

});

/*Add new article*/
app.post('/', function(req,res){
    var collection = db.get('articles');

    collection.insert({
        title: req.body.title,
        URL: req.body.URL,
        votes: 0,
        user: req.body.user,
        comments: []
    }, function(err, article){
        if(err) throw err;

        res.json(article);
    });
});

/*Add new comment to article*/
app.post('/:id', function(req,res){
    var collection = db.get('articles');
    var ObjectID = require('mongodb').ObjectID;
    collection.update( {_id: req.params.id},
        {$push: {
            comments: {
            commentid: new ObjectID(),
            user: req.body.commentuser,
            date: new Date(),
            votes: 0,
            body: req.body.commentbody
        }}
    }, function(err, article){
        if(err) throw err;

        res.json(article);
    });
});



module.exports = app;

