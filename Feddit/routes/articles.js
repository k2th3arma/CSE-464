var express = require('express');
var router = express.Router();

var monk = require('monk');
var db = monk('localhost:27017/feddit');

/*Obtain articles from db*/
router.get('/', function(req, res){
    var collection = db.get('articles');
    collection.find({}, function(err, articles){
        if (err) throw err;
        res.json(articles);
    });
});

/*Obtain an article via ID*/
router.get('/:id', function(req, res) {
    var collection = db.get('articles');
    collection.findOne({ _id: req.params.id }, function(err, articles){
        if (err) throw err;

      	res.json(articles);
    });
});

/*Delete article via ID*/
router.delete('/:id', function(req,res){
    var collection = db.get('articles');
    collection.remove({_id: req.params.id}, function(err,article){
        if (err) throw err;

        res.json(article);
    });
});

/*Add new article*/
router.post('/', function(req,res){
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
router.post('/:id', function(req,res){
    var collection = db.get('articles');
    collection.update( {_id: req.params.id},
        {$push: {
            comments: {
            user: req.body.user,
            date: "empty",
            votes: 0,
            body: req.body.body
        }}
    }, function(err, article){
        if(err) throw err;

        res.json(article);
    });
});

/* Upvote and downvote articles
router.put('/:id', function(req,res){
    var collection = db.get('articles');
    collection.findOne({_id: req.params.id} , function(err, article){
        if (err) throw err;
        
        collection.votes = collection.votes + 1;
        res.json(article);
    });
});
*/

module.exports = router;
