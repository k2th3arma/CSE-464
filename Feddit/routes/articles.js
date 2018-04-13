var express = require('express');
var router = express.Router();

var monk = require('monk');
var db = monk('localhost:27017/feddit');

router.get('/', function(req, res){
    var collection = db.get('articles');
    collection.find({}, function(err, articles){
        if (err) throw err;
        res.json(articles);
    });
});

router.get('/:id', function(req, res) {
    var collection = db.get('articles');
    collection.findOne({ _id: req.params.id }, function(err, articles){
        if (err) throw err;

      	res.json(articles);
    });
});

router.delete('/:id', function(req,res){
    var collection = db.get('articles');
    collection.remove({_id: req.params.id}, function(err,article){
        if (err) throw err;

        res.json(article);
    });
});

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

module.exports = router;
