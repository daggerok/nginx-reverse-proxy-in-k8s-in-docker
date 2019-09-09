# hugo how2
Quick guide how to use hugo from scratch...

```bash
hugo new site
cd docs
git clone https://github.com/budparr/gohugo-theme-ananke.git themes/ananke
rm -rf themes/ananke/.git
echo "theme = \"ananke\"" >> config.toml
hugo new guides/documentation.md
hugo server -D
open http://127.0.0.1:1313
hugo
ls public/
```

Read more on [hugo home site](https://gohugo.io/getting-started/quick-start/)
