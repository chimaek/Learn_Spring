import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { Link } from 'react-router-dom';

const useStyles = makeStyles({
  root: {
    minWidth: 275,
  },
  bullet: {
    display: 'inline-block',
    margin: '0 2px',
    transform: 'scale(0.8)',
  },
  title: {
    fontSize: 20,
  },
  pos: {
    marginBottom: 12,
    marginTop: 12,
  },
});

const BookItem = (props) => {
  const { id, title, author } = props.book;
  const classes = useStyles();
  const bull = <span className={classes.bullet}>.</span>;
  return (
    <Card>
      <CardContent>
        <Typography
          className={(classes.title, classes.pos)}
          color="textSecondary"
          gutterBottom
        >
          {title}
        </Typography>
        <Link to={'/post/' + id} component={Button} variant="contained">
          상세보기
        </Link>
      </CardContent>
    </Card>
  );
};
<div></div>;
export default BookItem;
