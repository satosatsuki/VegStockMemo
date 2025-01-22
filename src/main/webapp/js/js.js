/**
 * 
 */
// ページの読み込みが完了したら実行
document.addEventListener("DOMContentLoaded", function () {
    // テーブルの要素を取得
    const table = document.getElementById("vegetableTable");

    // テーブル全体にクリックイベントを設定
    table.addEventListener("click", function (event) {
        // クリックされた要素の最も近い親の <tr> を取得
        const clickedRow = event.target.closest("tr");

        // クリックされた行が有効で、data-id 属性を持っている場合のみ処理を実行
        if (clickedRow && clickedRow.dataset.id) {
            const vegetableId = clickedRow.dataset.id; // 行に設定されたデータIDを取得

            // 確認ダイアログを表示して削除するかどうか確認
            if (confirm("本当にこの行を削除しますか？")) {
                // サーバーに削除リクエストを送信
                deleteVegetable(vegetableId);
            }
        }
    });
});

// サーバーに削除リクエストを送信する関数
function deleteVegetable(id) {
    // fetch APIを使用してサーバーに削除リクエストを送信
    fetch("deleteVegetableServlet", {
        method: "POST", // HTTPメソッドをPOSTに設定
        headers: {
            "Content-Type": "application/x-www-form-urlencoded", // データ形式を指定
        },
        body: `id=${id}`, // 削除対象のIDをリクエストボディとして送信
    })
        .then(response => {
            if (response.ok) {
                // サーバーから成功レスポンスが返された場合
                alert("削除が成功しました！");
                location.reload(); // ページを再読み込みして更新
            } else {
                // サーバーからエラーレスポンスが返された場合
                alert("削除に失敗しました。");
            }
        })
        .catch(error => {
            // リクエスト中にエラーが発生した場合
            console.error("エラーが発生しました:", error);
            alert("通信エラーが発生しました。");
        });
}

function deleteVegetable(id) {
    fetch("deleteVegetableServlet", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
        },
        body: `id=${id}`,
    })
        .then(response => {
            if (response.ok) {
                alert("削除が成功しました！");
                // 行を削除する
                const row = document.querySelector(`tr[data-id='${id}']`);
                if (row) row.remove();
            } else {
                alert("削除に失敗しました。");
            }
        })
        .catch(error => {
            console.error("エラーが発生しました:", error);
        });
}
